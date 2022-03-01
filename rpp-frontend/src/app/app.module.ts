import { StudentService } from './services/student.service';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatNativeDateModule, MAT_DATE_LOCALE } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';

import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProjekatComponent } from './projekat/projekat.component';
import { SmerComponent } from './smer/smer.component';
import { GrupaComponent } from './grupa/grupa.component';
import { StudentComponent } from './student/student.component';
import { HomeComponent } from './core/home/home.component';
import { AuthorComponent } from './core/author/author.component';
import { AboutComponent } from './core/about/about.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { ProjekatService } from './services/projekat.service';
import { ProjekatDialogComponent } from './dialog/projekat-dialog/projekat-dialog.component';
import { SmerDialogComponent } from './dialog/smer-dialog/smer-dialog.component';
import { GrupaDialogComponent } from './dialog/grupa-dialog/grupa-dialog.component';
import { StudentDialogComponent } from './dialog/student-dialog/student-dialog.component';

import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { SmerService } from './services/smer.service';

import { GrupaService } from './services/grupa.service';
import { MatSelectModule } from '@angular/material/select';
import { MatSortModule } from '@angular/material/sort';
import {  MatPaginatorModule } from '@angular/material/paginator';


const Routes = [{path: 'projekat', component: ProjekatComponent},
                {path: 'smer', component: SmerComponent},
                {path: 'grupa', component: GrupaComponent},
                {path: 'student', component: StudentComponent},
                {path: 'home', component: HomeComponent},
                {path: 'about', component: AboutComponent},
                {path: 'author', component: AuthorComponent},
                {path: '', redirectTo: 'home', pathMatch: 'full'}];

@NgModule({
  declarations: [
    AppComponent,
    ProjekatComponent,
    SmerComponent,
    GrupaComponent,
    StudentComponent,
    HomeComponent,
    AuthorComponent,
    ProjekatDialogComponent,
    SmerDialogComponent,
    GrupaDialogComponent,
    StudentDialogComponent,
    AboutComponent,
    GrupaDialogComponent
  ],
  imports: [
    BrowserModule,
    MatButtonModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    MatGridListModule,
    MatExpansionModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatToolbarModule,
    MatSnackBarModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatSortModule,
    MatPaginatorModule,
    MatNativeDateModule,
    MatDatepickerModule,
    FormsModule,
    HttpClientModule,
    MatCheckboxModule,
    RouterModule.forRoot(Routes)   //za rute
  ],
  providers: [ ProjekatService, SmerService, GrupaService, StudentService],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
