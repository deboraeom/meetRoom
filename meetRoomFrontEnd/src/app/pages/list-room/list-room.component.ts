import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { room } from '../shared/models/room';
import { ServiceService } from '../shared/service/service.service';



@Component({
  selector: 'app-list-room',
  templateUrl: './list-room.component.html',
  styleUrls: ['./list-room.component.css']
})
export class ListRoomComponent implements OnInit {
  /*roomList: room[]=[
    {
      id:1,
      name: "Mysql",
      date: "hoje",
      startHour:"15hrs",
      endHour:"18hrs",
      responsible:"Joana",
     
  },
    { 
      id:2,
      name: "JPA",
    date: "hoje",
    startHour:"16hrs",
    endHour:"19hrs",
    responsible:"Serafim",
}];
   */
roomList: room[];

  constructor(private router: Router, private service: ServiceService) { }

  ngOnInit(): void {
   this.service.getRoom().subscribe((data: room[])=>{this.roomList=data})
  }
 atualizar(room: room): void{
   console.log("atualizou " + room.id)  
   this.router.navigate(['UpdateRoom']);
   

 }
 
 delete(room: room): void{
  console.log("deletou " + room.id)  

}}
