import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import {Room} from '../models/room'

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { 
    
  }
  getRooms(){
    return this.http.get("http://localhost:8080/api/v1/room")
  }
  getRoom(id):Observable<Room>{
    return this.http.get<Room>("http://localhost:8080/api/v1/room/"+id);
  }

  postRoom(room: Room) {
   this.http.post('http://localhost:8080/api/v1/room', room).subscribe((data: any)=>{console.log(data)})
  
  }

  deleteRoom(id:number){
    
    this.http.delete('http://localhost:8080/api/v1/room/' + id).subscribe((data: any)=>{console.log(data)})

  }
  putRoom(room: Room) {
    this.http.put('http://localhost:8080/api/v1/room', room).subscribe((data: any)=>{console.log(data)})
   
   }
 
}
