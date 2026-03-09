import { Component, OnInit } from '@angular/core';
import { ProjectService } from './services/project.service';
import { Project } from './models/project';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  projects: Project[] = [];
  filteredProjects: Project[] = [];
  searchTerm: string = '';
  selectedStatus: string = '';
  selectedPriority: string = '';
  selectedCategory: string = '';
  
  statuses = ['PLANNING', 'IN_PROGRESS', 'ON_HOLD', 'COMPLETED', 'CANCELLED'];
  priorities = ['LOW', 'MEDIUM', 'HIGH', 'CRITICAL'];
  categories = ['WEB_DEVELOPMENT', 'MOBILE_APP', 'MARKETING', 'RESEARCH', 'DESIGN', 'INFRASTRUCTURE', 'OTHER'];
  
  showModal: boolean = false;
  editingProject: Project | null = null;
  newProject: Project = {
    name: '',
    description: '',
    status: 'PLANNING',
    priority: 'MEDIUM',
    category: 'WEB_DEVELOPMENT',
    startDate: '',
    endDate: '',
    progress: 0,
    budget: 0,
    teamMembers: '',
    projectManager: '',
    notes: ''
  };

  constructor(private projectService: ProjectService) {}

  ngOnInit() {
    this.loadProjects();
  }

  loadProjects() {
    this.projectService.getAllProjects().subscribe(
      (projects) => {
        this.projects = projects;
        this.applyFilters();
      },
      (error) => {
        console.error('Error loading projects:', error);
      }
    );
  }

  applyFilters() {
    let filtered = [...this.projects];

    // Apply search filter
    if (this.searchTerm.trim() !== '') {
      this.projectService.searchProjects(this.searchTerm).subscribe(
        (searchedProjects) => {
          filtered = searchedProjects;
          this.applyOtherFilters(filtered);
        },
        (error) => {
          console.error('Error searching projects:', error);
          this.applyOtherFilters(filtered);
        }
      );
    } else {
      this.applyOtherFilters(filtered);
    }
  }

  applyOtherFilters(projects: Project[]) {
    let filtered = [...projects];

    // Apply status filter
    if (this.selectedStatus && this.selectedStatus !== '') {
      filtered = filtered.filter(project => project.status === this.selectedStatus);
    }

    // Apply priority filter
    if (this.selectedPriority && this.selectedPriority !== '') {
      filtered = filtered.filter(project => project.priority === this.selectedPriority);
    }

    // Apply category filter
    if (this.selectedCategory && this.selectedCategory !== '') {
      filtered = filtered.filter(project => project.category === this.selectedCategory);
    }

    // Sort by status priority and then by name
    filtered.sort((a, b) => {
      const statusOrder = ['IN_PROGRESS', 'PLANNING', 'ON_HOLD', 'COMPLETED', 'CANCELLED'];
      const statusA = statusOrder.indexOf(a.status || '');
      const statusB = statusOrder.indexOf(b.status || '');
      if (statusA !== statusB) {
        return statusA - statusB;
      }
      return (a.name || '').localeCompare(b.name || '');
    });

    this.filteredProjects = filtered;
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

  clearFilters() {
    this.searchTerm = '';
    this.selectedStatus = '';
    this.selectedPriority = '';
    this.selectedCategory = '';
    this.applyFilters();
  }

  openModal(project?: Project) {
    if (project) {
      this.editingProject = { ...project };
      this.newProject = { ...project };
    } else {
      this.editingProject = null;
      this.newProject = {
        name: '',
        description: '',
        status: 'PLANNING',
        priority: 'MEDIUM',
        category: 'WEB_DEVELOPMENT',
        startDate: '',
        endDate: '',
        progress: 0,
        budget: 0,
        teamMembers: '',
        projectManager: '',
        notes: ''
      };
    }
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.editingProject = null;
  }

  saveProject() {
    if (this.editingProject) {
      this.updateProject();
    } else {
      this.createProject();
    }
  }

  createProject() {
    this.projectService.createProject(this.newProject).subscribe(
      (project) => {
        this.projects.push(project);
        this.applyFilters();
        this.closeModal();
      },
      (error) => {
        console.error('Error creating project:', error);
      }
    );
  }

  updateProject() {
    if (this.editingProject && this.editingProject.id) {
      this.projectService.updateProject(this.editingProject.id, this.newProject).subscribe(
        (project) => {
          const index = this.projects.findIndex(p => p.id === project.id);
          if (index !== -1) {
            this.projects[index] = project;
          }
          this.applyFilters();
          this.closeModal();
        },
        (error) => {
          console.error('Error updating project:', error);
        }
      );
    }
  }

  deleteProject(id: number) {
    if (confirm('Are you sure you want to delete this project?')) {
      this.projectService.deleteProject(id).subscribe(
        () => {
          this.projects = this.projects.filter(p => p.id !== id);
          this.applyFilters();
        },
        (error) => {
          console.error('Error deleting project:', error);
        }
      );
    }
  }

  getTotalCount(): number {
    return this.projects.length;
  }

  getActiveCount(): number {
    return this.projects.filter(p => p.status === 'IN_PROGRESS').length;
  }

  getCompletedCount(): number {
    return this.projects.filter(p => p.status === 'COMPLETED').length;
  }

  getTotalBudget(): number {
    return this.projects.reduce((sum, project) => sum + (project.budget || 0), 0);
  }

  formatDate(dateString: string | undefined): string {
    if (!dateString) return 'N/A';
    const date = new Date(dateString);
    return date.toLocaleDateString('en-US', { 
      year: 'numeric', 
      month: 'short', 
      day: 'numeric' 
    });
  }

  formatCurrency(amount: number | undefined): string {
    if (!amount || amount === 0) return 'N/A';
    return new Intl.NumberFormat('en-US', {
      style: 'currency',
      currency: 'USD'
    }).format(amount);
  }

  getStatusClass(status: string | undefined): string {
    if (!status) return '';
    return `status-${status.toLowerCase().replace('_', '-')}`;
  }

  getPriorityClass(priority: string | undefined): string {
    if (!priority) return '';
    return `priority-${priority.toLowerCase()}`;
  }
}

