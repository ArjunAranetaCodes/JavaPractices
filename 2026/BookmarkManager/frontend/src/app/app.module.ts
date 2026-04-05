import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { BookmarkListComponent } from './components/bookmark-list/bookmark-list.component';
import { BookmarkFormComponent } from './components/bookmark-form/bookmark-form.component';

@NgModule({
  declarations: [
    AppComponent,
    BookmarkListComponent,
    BookmarkFormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
