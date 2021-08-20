import { HttpClient } from '@angular/common/http';
import { Injectable, SystemJsNgModuleLoader } from '@angular/core';

import {room} from '../models/room'

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { 
    
  }
  getRoom(){
    return this.http.get("http://localhost:8080/api/v1/room")
  }

  postRoom(room: room) {
   this.http.post('http://localhost:8080/api/v1/room', room).subscribe((data: any)=>{console.log(data)})
  
  }

  deleteRoom(id:number){
    console.log('http://localhost:8080/api/v1/room/' + id)
    this.http.delete('http://localhost:8080/api/v1/room/' + id).subscribe((data: any)=>{console.log(data)})

  }
}
