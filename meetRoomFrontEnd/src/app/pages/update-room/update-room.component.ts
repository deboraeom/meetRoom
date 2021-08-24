import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {  ActivatedRoute, Router } from '@angular/router';
import { Room } from '../shared/models/room';
import { ServiceService } from '../shared/service/service.service';

@Component({
  selector: 'app-update-room',
  templateUrl: './update-room.component.html',
  styleUrls: ['./update-room.component.css']
})
export class UpdateRoomComponent implements OnInit {
  
  
  id: number;
  cadastroform: FormGroup;

  constructor(private fb: FormBuilder, private service: ServiceService, private route: Router, private router: ActivatedRoute) {
   
   }
   get f() {
    return this.cadastroform.controls;
  }

  ngOnInit(): void {
    this.id = this.router.snapshot.params['id'];
    console.log(this.id)
    
    this.service.getRoom(this.id)
    .subscribe((room: Room) => this.createForm(room));   
   
  }

  createForm(room:Room){
    this.cadastroform=this.fb.group(
      {
       name:[room.name, [Validators.required,Validators.minLength(2), Validators.maxLength(40)]],
      date:[room.date, [Validators.required]],
      startHour:[room.startHour, [Validators.required]],
      endHour:[room.endHour, [Validators.required]],
      responsible:[room.responsible, [Validators.required, Validators.minLength(2), Validators.maxLength(40)]],
      
    })
    
  }
  

  save(){
    const roomToUpdate = this.cadastroform.getRawValue() as Room;
    roomToUpdate.id=this.id;
    this.service.putRoom(roomToUpdate);
    alert("Update")
    this.route.navigate(['']);
   

  }
  cancel(){
    this.route.navigate(['']);

  }

}
