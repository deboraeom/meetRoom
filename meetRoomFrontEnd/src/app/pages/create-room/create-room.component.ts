import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { room } from '../shared/models/room';
import { ServiceService } from '../shared/service/service.service';


@Component({
  selector: 'app-create-room',
  templateUrl: './create-room.component.html',
  styleUrls: ['./create-room.component.css']
})
export class CreateRoomComponent implements OnInit {
  public cadastroform: FormGroup;


  constructor(private fb: FormBuilder, private service: ServiceService) { }

  ngOnInit(): void {

    this.cadastroform=this.fb.group({
      name:['', [Validators.required,Validators.minLength(2), Validators.maxLength(40)]],
      date:['', [Validators.required]],
      startHour:['', [Validators.required]],
      endHour:['', [Validators.required]],
      responsible:['', [Validators.required, Validators.minLength(2), Validators.maxLength(40)]],
      
    })
  }

  save(){  

   this.service.postRoom(this.cadastroform.value);
   this.cadastroform=this.fb.group({
      name:'',
      date:'',
      startHour:'',
      endHour:'',
      responsible:'',  
  })}

  cancel():void{
    
  }

}
