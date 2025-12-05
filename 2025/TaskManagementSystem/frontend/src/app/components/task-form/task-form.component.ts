import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Task, TaskStatus, TaskPriority } from '../../models/task.model';
import { TaskService } from '../../services/task.service';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class TaskFormComponent implements OnInit {
  task: Task = {
    title: '',
    description: '',
    status: TaskStatus.PENDING,
    priority: TaskPriority.MEDIUM,
    assignedTo: '',
    createdBy: ''
  };

  isEditMode: boolean = false;
  taskId?: number;

  statusOptions = Object.values(TaskStatus);
  priorityOptions = Object.values(TaskPriority);

  constructor(
    private taskService: TaskService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if (params['id']) {
        this.taskId = +params['id'];
        this.isEditMode = true;
        this.loadTask();
      }
    });
  }

  loadTask(): void {
    if (this.taskId) {
      this.taskService.getTaskById(this.taskId).subscribe({
        next: (task) => {
          this.task = task;
        },
        error: (error) => {
          console.error('Error loading task:', error);
          this.router.navigate(['/tasks']);
        }
      });
    }
  }

  onSubmit(): void {
    if (!this.task.title || this.task.title.trim() === '') {
      alert('Task title is required');
      return;
    }

    if (this.isEditMode && this.taskId) {
      this.taskService.updateTask(this.taskId, this.task).subscribe({
        next: () => {
          this.router.navigate(['/tasks']);
        },
        error: (error) => {
          console.error('Error updating task:', error);
          alert('Error updating task');
        }
      });
    } else {
      this.taskService.createTask(this.task).subscribe({
        next: () => {
          this.router.navigate(['/tasks']);
        },
        error: (error) => {
          console.error('Error creating task:', error);
          alert('Error creating task');
        }
      });
    }
  }

  cancel(): void {
    this.router.navigate(['/tasks']);
  }
}

