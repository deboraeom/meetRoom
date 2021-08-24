import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Room } from '../shared/models/room';
import { ServiceService } from '../shared/service/service.service';



@Component({
  selector: 'app-list-room',
  templateUrl: './list-room.component.html',
  styleUrls: ['./list-room.component.css']
})
export class ListRoomComponent implements OnInit {

roomList: Room[];

  constructor(private router: Router, private service: ServiceService) { }

  ngOnInit(): void {
   

    this.carregarRoom()
 
  }
  carregarRoom(){
    this.service.getRooms().subscribe((data: Room[])=>{
      this.roomList=data
      
      this.roomList.map(function(Room) {
        var splits = Room.date.split('-', 3);
        var splits2 = splits[2].split("T",2)        
        Room.date= splits2[0]+"-"+splits[1]+"-"+splits[0]
    })
    ;})

  }

    
  
 atualizar(room: Room): void{
  this.router.navigate(['UpdateRoom', room.id]);
 
   

 }
 
 delete(room: Room): void{   
 this.service.deleteRoom(room.id);  
 this.carregarRoom()
 this.router.navigate([''])

}

cancelar(){
  this.router.navigate([''])

}

formatar(data: String): string{
  data="2021-08-25T03:00:00.000Z"  
 var splits = data.split('-', 3);
 var splits2 = splits[2].split("T",2)
  data.split  
  return splits2[0]+"-"+splits[1]+"-"+splits[0]

}
formaRoomDate(room: Room){


}

}
