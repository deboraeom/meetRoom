import { Input } from '@angular/core';
import { Component } from '@angular/core';
import { AbstractControl, FormGroup } from '@angular/forms';
import { VFieldsService } from '../../../service/v-fields.service';


@Component({
  selector: 'app-input-text',
  templateUrl: './input-text.component.html',
  styleUrls: ['./input-text.component.css']

  })
  export class InputTextComponent {
  
  
    @Input() titulo: string;
    @Input() formGroup: FormGroup;
    @Input() controlName: string;
   
    
  
    constructor(public validacao: VFieldsService) { }
  
    get formControl(): AbstractControl {
      return this.formGroup.controls[this.controlName];
    }}