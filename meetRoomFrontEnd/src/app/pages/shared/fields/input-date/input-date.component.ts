import { Component, Input, OnInit } from '@angular/core';
import { FormGroup, AbstractControl } from '@angular/forms';
import { VFieldsService } from '../../service/v-fields.service';
import { MatDateFormats, MAT_NATIVE_DATE_FORMATS,MAT_DATE_FORMATS, DateAdapter  } from '@angular/material/core';



export const GRI_DATE_FORMATS: MatDateFormats = {
  ...MAT_NATIVE_DATE_FORMATS,
  display: {
    ...MAT_NATIVE_DATE_FORMATS.display,
    dateInput: {
      year: 'numeric',
      month: 'short',
      day: 'numeric',
    } as Intl.DateTimeFormatOptions,
  }
};



@Component({
  selector: 'app-input-date',
  templateUrl: './input-date.component.html',
  styleUrls: ['./input-date.component.css'],
  providers: [
    { provide: MAT_DATE_FORMATS, useValue: GRI_DATE_FORMATS },
  ]
})

export class InputDateComponent  {

  minDate: Date;

  @Input() titulo: string;
  @Input() formGroup: FormGroup;
  @Input() controlName: string;

  constructor(public validacao: VFieldsService, private readonly adapter: DateAdapter<Date>) { 
    this.adapter.setLocale('pt-br');

    this.minDate = new Date();
    
  }

  get formControl(): AbstractControl {
    return this.formGroup.controls[this.controlName];
  }
 
}