import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { CreateRoomComponent } from './pages/create-room/create-room.component';
import { ListRoomComponent } from './pages/list-room/list-room.component';
import { UpdateRoomComponent } from './pages/update-room/update-room.component';
import {  HttpClientModule } from '@angular/common/http';
import { InputTextComponent } from './pages/shared/fields/inputText/input-text/input-text.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog';
import {MatIconModule} from '@angular/material/icon';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { InputDateComponent } from './pages/shared/fields/input-date/input-date.component';



@NgModule({
  declarations: [
    AppComponent,
    CreateRoomComponent,
    ListRoomComponent,
    UpdateRoomComponent,
    InputTextComponent,
    InputDateComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule ,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatDialogModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatDatepickerModule,
    MatNativeDateModule,
 
    HttpClientModule, 
    ReactiveFormsModule ,
    FormsModule,
   

    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
