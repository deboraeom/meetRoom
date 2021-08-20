import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { CreateRoomComponent } from './pages/create-room/create-room.component';
import { ListRoomComponent } from './pages/list-room/list-room.component';
import { UpdateRoomComponent } from './pages/update-room/update-room.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { InputTextComponent } from './pages/shared/fields/inputText/input-text/input-text.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog';
import {MatIconModule} from '@angular/material/icon';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';



@NgModule({
  declarations: [
    AppComponent,
    CreateRoomComponent,
    ListRoomComponent,
    UpdateRoomComponent,
    InputTextComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatDialogModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    HttpClientModule, 
    ReactiveFormsModule ,
    FormsModule,
   

    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
