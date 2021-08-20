import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateRoomComponent } from './pages/create-room/create-room.component';
import { ListRoomComponent } from './pages/list-room/list-room.component';
import { UpdateRoomComponent } from './pages/update-room/update-room.component';



const routes: Routes = [
  {
    path: 'CreateRoom',
    component: CreateRoomComponent
  },

  {
    path: 'UpdateRoom',
    component: UpdateRoomComponent
  },

  {
    path: 'ListRoom',
    component: ListRoomComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
