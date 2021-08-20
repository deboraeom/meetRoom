import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { room } from '../shared/models/room';

@Component({
  selector: 'app-update-room',
  templateUrl: './update-room.component.html',
  styleUrls: ['./update-room.component.css']
})
export class UpdateRoomComponent implements OnInit {
  public cadastroform: FormGroup;
  room: room=
    {
      id:1,
      name: "Mysql",
      date: "hoje",
      startHour:"15hrs",
      endHour:"18hrs",
      responsible:"Joana",
     
  };


  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    
    this.cadastroform=this.fb.group({
      name:[this.room.name, [Validators.required,Validators.minLength(2), Validators.maxLength(40)]],
      date:[this.room.date, [Validators.required]],
      startHour:[this.room.startHour, [Validators.required]],
      endHour:[this.room.endHour, [Validators.required]],
      responsible:[this.room.responsible, [Validators.required, Validators.minLength(2), Validators.maxLength(40)]],
      
    })
  }
  save(){

  }
  cancel(){

  }
}
