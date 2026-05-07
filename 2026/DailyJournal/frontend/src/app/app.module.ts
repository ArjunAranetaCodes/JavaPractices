import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { JournalListComponent } from './components/journal-list/journal-list.component';
import { JournalFormComponent } from './components/journal-form/journal-form.component';

@NgModule({
  declarations: [
    AppComponent,
    JournalListComponent,
    JournalFormComponent
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
