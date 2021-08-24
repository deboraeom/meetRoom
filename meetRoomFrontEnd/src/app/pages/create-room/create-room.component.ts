import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Room } from '../shared/models/room';
import { ServiceService } from '../shared/service/service.service';


@Component({
  selector: 'app-create-room',
  templateUrl: './create-room.component.html',
  styleUrls: ['./create-room.component.css']
})
export class CreateRoomComponent implements OnInit {
  public cadastroform: FormGroup;
  minDate: Date;


  constructor(private fb: FormBuilder, private service: ServiceService, private router: Router) {
    this.minDate = new Date();
   }

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
  
   if( this.cadastroform.invalid){
    alert("Preencha correntamento o formulário")

   }else{

   this.service.postRoom(this.cadastroform.value);
   this.cadastroform.reset();
   alert("Salvo")}
  }

  cancel():void{
    this.router.navigate(['']);
    
  }

}
