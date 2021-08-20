import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

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
    return this.http.post('http://localhost:8080/api/v1/room', room)
  }
}
