import { Input } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormGroup } from '@angular/forms';
import { VFieldsService } from '../../../service/v-fields.service';


@Component({
  selector: 'app-input-text',
  templateUrl: './input-text.component.html',
  styleUrls: ['./input-text.component.css']

  })
  export class InputTextComponent {
    //titulo is the description  on input space used for the user undestand what is necessary to do
  //titulo o que estará descrito no espaço do input para que o usuário possa enteder o que deverá ser iserido
  // formGroup is the field formGroug
  //formGroup o form grupo que esta associado 
  // Control name the field controlName
  //Control name o nome do controle associado
  
    @Input() titulo: string;
    @Input() formGroup: FormGroup;
    @Input() controlName: string;
    
  
    constructor(public validacao: VFieldsService) { }
  
    get formControl(): AbstractControl {
      return this.formGroup.controls[this.controlName];
    }}