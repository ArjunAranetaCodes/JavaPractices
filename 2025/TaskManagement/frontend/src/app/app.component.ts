import { Component, OnInit } from '@angular/core';
import { TaskService } from './services/task.service';
import { Task } from './models/task';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  tasks: Task[] = [];
  filteredTasks: Task[] = [];
  searchTerm: string = '';
  selectedStatus: string = '';
  selectedPriority: string = '';
  selectedCategory: string = '';
  selectedAssignee: string = '';
  
  statuses = ['TODO', 'IN_PROGRESS', 'DONE', 'CANCELLED'];
  priorities = ['LOW', 'MEDIUM', 'HIGH', 'URGENT'];
  categories = ['WORK', 'PERSONAL', 'SHOPPING', 'HEALTH', 'EDUCATION', 'OTHER'];
  assignees: string[] = [];
  
  showModal: boolean = false;
  editingTask: Task | null = null;
  newTask: Task = {
    title: '',
    description: '',
    priority: 'MEDIUM',
    status: 'TODO',
    category: 'WORK',
    dueDate: '',
    assignee: '',
    tags: ''
  };

  constructor(private taskService: TaskService) {}

  ngOnInit() {
    this.loadTasks();
  }

  loadTasks() {
    this.taskService.getAllTasks().subscribe(
      (tasks) => {
        this.tasks = tasks;
        this.extractAssignees();
        this.applyFilters();
      },
      (error) => {
        console.error('Error loading tasks:', error);
      }
    );
  }

  extractAssignees() {
    const assigneeSet = new Set<string>();
    this.tasks.forEach(task => {
      if (task.assignee) {
        assigneeSet.add(task.assignee);
      }
    });
    this.assignees = Array.from(assigneeSet).sort();
  }

  applyFilters() {
    let filtered = [...this.tasks];

    // Apply search filter
    if (this.searchTerm.trim() !== '') {
      this.taskService.searchTasks(this.searchTerm).subscribe(
        (searchedTasks) => {
          filtered = searchedTasks;
          this.applyOtherFilters(filtered);
        },
        (error) => {
          console.error('Error searching tasks:', error);
          this.applyOtherFilters(filtered);
        }
      );
    } else {
      this.applyOtherFilters(filtered);
    }
  }

  applyOtherFilters(tasks: Task[]) {
    let filtered = [...tasks];

    // Apply status filter
    if (this.selectedStatus && this.selectedStatus !== '') {
      filtered = filtered.filter(task => task.status === this.selectedStatus);
    }

    // Apply priority filter
    if (this.selectedPriority && this.selectedPriority !== '') {
      filtered = filtered.filter(task => task.priority === this.selectedPriority);
    }

    // Apply category filter
    if (this.selectedCategory && this.selectedCategory !== '') {
      filtered = filtered.filter(task => task.category === this.selectedCategory);
    }

    // Apply assignee filter
    if (this.selectedAssignee && this.selectedAssignee !== '') {
      filtered = filtered.filter(task => task.assignee === this.selectedAssignee);
    }

    // Sort: overdue first, then by priority (URGENT > HIGH > MEDIUM > LOW), then by due date
    filtered.sort((a, b) => {
      const aOverdue = this.isOverdue(a);
      const bOverdue = this.isOverdue(b);
      if (aOverdue && !bOverdue) return -1;
      if (!aOverdue && bOverdue) return 1;
      
      const priorityOrder = { 'URGENT': 4, 'HIGH': 3, 'MEDIUM': 2, 'LOW': 1 };
      const aPriority = priorityOrder[a.priority || 'MEDIUM'] || 0;
      const bPriority = priorityOrder[b.priority || 'MEDIUM'] || 0;
      if (aPriority !== bPriority) return bPriority - aPriority;
      
      if (a.dueDate && b.dueDate) {
        return a.dueDate.localeCompare(b.dueDate);
      }
      return (a.title || '').localeCompare(b.title || '');
    });

    this.filteredTasks = filtered;
  }

  isOverdue(task: Task): boolean {
    if (!task.dueDate || task.status === 'DONE') {
      return false;
    }
    const today = new Date();
    today.setHours(0, 0, 0, 0);
    const dueDate = new Date(task.dueDate);
    dueDate.setHours(0, 0, 0, 0);
    return dueDate < today;
  }

  isDueToday(task: Task): boolean {
    if (!task.dueDate) {
      return false;
    }
    const today = new Date();
    today.setHours(0, 0, 0, 0);
    const dueDate = new Date(task.dueDate);
    dueDate.setHours(0, 0, 0, 0);
    return dueDate.getTime() === today.getTime();
  }

  onSearchChange() {
    this.applyFilters();
  }

  onStatusChange() {
    this.applyFilters();
  }

  onPriorityChange() {
    this.applyFilters();
  }

  onCategoryChange() {
    this.applyFilters();
  }

  onAssigneeChange() {
    this.applyFilters();
  }

  clearFilters() {
    this.searchTerm = '';
    this.selectedStatus = '';
    this.selectedPriority = '';
    this.selectedCategory = '';
    this.selectedAssignee = '';
    this.applyFilters();
  }

  openModal(task?: Task) {
    if (task) {
      this.editingTask = { ...task };
      this.newTask = { ...task };
    } else {
      this.editingTask = null;
      this.newTask = {
        title: '',
        description: '',
        priority: 'MEDIUM',
        status: 'TODO',
        category: 'WORK',
        dueDate: '',
        assignee: '',
        tags: ''
      };
    }
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.editingTask = null;
  }

  saveTask() {
    if (this.editingTask) {
      this.updateTask();
    } else {
      this.createTask();
    }
  }

  createTask() {
    this.taskService.createTask(this.newTask).subscribe(
      (task) => {
        this.tasks.push(task);
        this.extractAssignees();
        this.applyFilters();
        this.closeModal();
      },
      (error) => {
        console.error('Error creating task:', error);
      }
    );
  }

  updateTask() {
    if (this.editingTask && this.editingTask.id) {
      this.taskService.updateTask(this.editingTask.id, this.newTask).subscribe(
        (task) => {
          const index = this.tasks.findIndex(t => t.id === task.id);
          if (index !== -1) {
            this.tasks[index] = task;
          }
          this.extractAssignees();
          this.applyFilters();
          this.closeModal();
        },
        (error) => {
          console.error('Error updating task:', error);
        }
      );
    }
  }

  deleteTask(id: number) {
    if (confirm('Are you sure you want to delete this task?')) {
      this.taskService.deleteTask(id).subscribe(
        () => {
          this.tasks = this.tasks.filter(t => t.id !== id);
          this.extractAssignees();
          this.applyFilters();
        },
        (error) => {
          console.error('Error deleting task:', error);
        }
      );
    }
  }

  getTotalCount(): number {
    return this.tasks.length;
  }

  getTodoCount(): number {
    return this.tasks.filter(t => t.status === 'TODO').length;
  }

  getInProgressCount(): number {
    return this.tasks.filter(t => t.status === 'IN_PROGRESS').length;
  }

  getDoneCount(): number {
    return this.tasks.filter(t => t.status === 'DONE').length;
  }

  getOverdueCount(): number {
    return this.tasks.filter(t => this.isOverdue(t)).length;
  }

  getUrgentCount(): number {
    return this.tasks.filter(t => t.priority === 'URGENT').length;
  }

  formatDate(dateString: string | undefined): string {
    if (!dateString) return 'No due date';
    const date = new Date(dateString);
    return date.toLocaleDateString('en-US', { 
      year: 'numeric', 
      month: 'short', 
      day: 'numeric' 
    });
  }

  getStatusClass(status: string | undefined): string {
    if (!status) return '';
    return `status-${status.toLowerCase()}`;
  }

  getPriorityClass(priority: string | undefined): string {
    if (!priority) return '';
    return `priority-${priority.toLowerCase()}`;
  }

  getTaskCardClass(task: Task): string {
    if (this.isOverdue(task)) return 'overdue';
    if (task.priority === 'URGENT') return 'urgent';
    if (task.priority === 'HIGH') return 'high';
    if (task.priority === 'MEDIUM') return 'medium';
    if (task.priority === 'LOW') return 'low';
    return '';
  }

  getDateBadgeClass(task: Task): string {
    if (this.isOverdue(task)) return 'overdue';
    if (this.isDueToday(task)) return 'due-today';
    return '';
  }

  getTagsArray(tags: string | undefined): string[] {
    if (!tags) return [];
    return tags.split(',').map(tag => tag.trim()).filter(tag => tag.length > 0);
  }
}

