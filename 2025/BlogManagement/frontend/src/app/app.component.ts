import { Component, OnInit } from '@angular/core';
import { BlogPostService } from './services/blog-post.service';
import { BlogPost } from './models/blog-post';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  posts: BlogPost[] = [];
  filteredPosts: BlogPost[] = [];
  searchTerm: string = '';
  selectedStatus: string = '';
  selectedCategory: string = '';
  selectedAuthor: string = '';
  
  statuses = ['DRAFT', 'PUBLISHED', 'ARCHIVED'];
  categories = ['TECHNOLOGY', 'LIFESTYLE', 'TRAVEL', 'FOOD', 'HEALTH', 'BUSINESS', 'EDUCATION', 'ENTERTAINMENT', 'OTHER'];
  authors: string[] = [];
  
  showModal: boolean = false;
  editingPost: BlogPost | null = null;
  newPost: BlogPost = {
    title: '',
    content: '',
    author: '',
    category: 'TECHNOLOGY',
    tags: '',
    status: 'DRAFT',
    publicationDate: '',
    readingTime: 0,
    featured: false,
    excerpt: ''
  };

  constructor(private blogPostService: BlogPostService) {}

  ngOnInit() {
    this.loadPosts();
  }

  loadPosts() {
    this.blogPostService.getAllPosts().subscribe(
      (posts) => {
        this.posts = posts;
        this.extractAuthors();
        this.applyFilters();
      },
      (error) => {
        console.error('Error loading posts:', error);
      }
    );
  }

  extractAuthors() {
    const authorSet = new Set<string>();
    this.posts.forEach(post => {
      if (post.author) {
        authorSet.add(post.author);
      }
    });
    this.authors = Array.from(authorSet).sort();
  }

  applyFilters() {
    let filtered = [...this.posts];

    // Apply search filter
    if (this.searchTerm.trim() !== '') {
      this.blogPostService.searchPosts(this.searchTerm).subscribe(
        (searchedPosts) => {
          filtered = searchedPosts;
          this.applyOtherFilters(filtered);
        },
        (error) => {
          console.error('Error searching posts:', error);
          this.applyOtherFilters(filtered);
        }
      );
    } else {
      this.applyOtherFilters(filtered);
    }
  }

  applyOtherFilters(posts: BlogPost[]) {
    let filtered = [...posts];

    // Apply status filter
    if (this.selectedStatus && this.selectedStatus !== '') {
      filtered = filtered.filter(post => post.status === this.selectedStatus);
    }

    // Apply category filter
    if (this.selectedCategory && this.selectedCategory !== '') {
      filtered = filtered.filter(post => post.category === this.selectedCategory);
    }

    // Apply author filter
    if (this.selectedAuthor && this.selectedAuthor !== '') {
      filtered = filtered.filter(post => post.author === this.selectedAuthor);
    }

    // Sort: featured first, then by publication date (most recent first), then by title
    filtered.sort((a, b) => {
      if (a.featured && !b.featured) return -1;
      if (!a.featured && b.featured) return 1;
      if (a.publicationDate && b.publicationDate) {
        return b.publicationDate.localeCompare(a.publicationDate);
      }
      return (a.title || '').localeCompare(b.title || '');
    });

    this.filteredPosts = filtered;
  }

  onSearchChange() {
    this.applyFilters();
  }

  onStatusChange() {
    this.applyFilters();
  }

  onCategoryChange() {
    this.applyFilters();
  }

  onAuthorChange() {
    this.applyFilters();
  }

  clearFilters() {
    this.searchTerm = '';
    this.selectedStatus = '';
    this.selectedCategory = '';
    this.selectedAuthor = '';
    this.applyFilters();
  }

  openModal(post?: BlogPost) {
    if (post) {
      this.editingPost = { ...post };
      this.newPost = { ...post };
    } else {
      this.editingPost = null;
      this.newPost = {
        title: '',
        content: '',
        author: '',
        category: 'TECHNOLOGY',
        tags: '',
        status: 'DRAFT',
        publicationDate: '',
        readingTime: 0,
        featured: false,
        excerpt: ''
      };
    }
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.editingPost = null;
  }

  savePost() {
    if (this.editingPost) {
      this.updatePost();
    } else {
      this.createPost();
    }
  }

  createPost() {
    this.blogPostService.createPost(this.newPost).subscribe(
      (post) => {
        this.posts.push(post);
        this.extractAuthors();
        this.applyFilters();
        this.closeModal();
      },
      (error) => {
        console.error('Error creating post:', error);
      }
    );
  }

  updatePost() {
    if (this.editingPost && this.editingPost.id) {
      this.blogPostService.updatePost(this.editingPost.id, this.newPost).subscribe(
        (post) => {
          const index = this.posts.findIndex(p => p.id === post.id);
          if (index !== -1) {
            this.posts[index] = post;
          }
          this.extractAuthors();
          this.applyFilters();
          this.closeModal();
        },
        (error) => {
          console.error('Error updating post:', error);
        }
      );
    }
  }

  deletePost(id: number) {
    if (confirm('Are you sure you want to delete this post?')) {
      this.blogPostService.deletePost(id).subscribe(
        () => {
          this.posts = this.posts.filter(p => p.id !== id);
          this.extractAuthors();
          this.applyFilters();
        },
        (error) => {
          console.error('Error deleting post:', error);
        }
      );
    }
  }

  getTotalCount(): number {
    return this.posts.length;
  }

  getPublishedCount(): number {
    return this.posts.filter(p => p.status === 'PUBLISHED').length;
  }

  getDraftCount(): number {
    return this.posts.filter(p => p.status === 'DRAFT').length;
  }

  getFeaturedCount(): number {
    return this.posts.filter(p => p.featured).length;
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

  getStatusClass(status: string | undefined): string {
    if (!status) return '';
    return `status-${status.toLowerCase()}`;
  }

  getTagsArray(tags: string | undefined): string[] {
    if (!tags) return [];
    return tags.split(',').map(tag => tag.trim()).filter(tag => tag.length > 0);
  }

  truncateText(text: string | undefined, maxLength: number = 150): string {
    if (!text) return '';
    if (text.length <= maxLength) return text;
    return text.substring(0, maxLength) + '...';
  }
}


