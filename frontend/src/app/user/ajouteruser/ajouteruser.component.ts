import { Component } from '@angular/core';
import { ajax } from 'rxjs/ajax';
import { tap } from 'rxjs/operators';
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Observable, Subscriber } from 'rxjs';
import { UserService } from '../../services/userService';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2/dist/sweetalert2.js';
import { Router } from '@angular/router';
import { User } from '../../models/user';

@Component({
  selector: 'app-ajouteruser',
  templateUrl: './ajouteruser.component.html',
  styleUrls: ['./ajouteruser.component.css']
})
export class AjouteruserComponent  {
 
  clientsaveform!: FormGroup;
  user: User = new User();
  submitted = false;
  prenomAdd = null;
  nomEnsiegnant:any;
  isHidden:any;
  listEnsiegnants:any;


  constructor(private userservice: UserService,private fb: FormBuilder,private form: FormBuilder,private http: HttpClient,private router : Router) { }

 
  ngOnInit() {
    this.clientsaveform = this.fb.group({
      
      nom: ['', [Validators.required]],
      prenom: ['', [Validators.required]],
      adresse: ['', [Validators.required]],
    });

  }


  httpOptions = {
    headers: new HttpHeaders({
      'Content-adresse': 'application/json'
    })
  }



  saveClient() {
    const nomValue = this.clientsaveform.get('nom')!.value as string;
    const prenomValue = this.clientsaveform.get('prenom')!.value as string;
    const adresseValue = this.clientsaveform.get('adresse')!.value as string;

    this.user = {
      nom: nomValue,
      prenom: prenomValue,
      adresse: adresseValue
    };

    this.submitted = true;
    this.save();
  }

  save() {
    this.userservice.createUser(this.user)
      .subscribe(data => console.log(data), error => console.log(error));
    this.user = new User();
  }

  get form_control() {
    return this.clientsaveform.controls;
  }

  addUserForm() {
    this.submitted = false;
    this.clientsaveform.reset();
  }






}


//https://stackblitz.com/edit/ajax-angular-army?file=src%2Fapp%2Fapp.component.ts