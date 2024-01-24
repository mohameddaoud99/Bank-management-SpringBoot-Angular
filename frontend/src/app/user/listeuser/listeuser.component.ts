import { Component,OnInit   } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../../services/userService';
import {HttpClient, HttpErrorResponse,HttpHeaders} from '@angular/common/http';
import { ajax } from 'rxjs/ajax';
import { tap } from 'rxjs/operators';
import { User } from '../../models/user';
import { Observable,Subject } from "rxjs";



import Swal from 'sweetalert2';
@Component({
  selector: 'app-listeuser',
  templateUrl: './listeuser.component.html',
  styleUrls: ['./listeuser.component.css']
})

 /* clients: any;
  accountForm: FormGroup;

  constructor(private httpClient: HttpClient,private formBuilder: FormBuilder,private userService: ServiceuserService) {
    // Initialize the form in the constructor
    this.accountForm = this.formBuilder.group({
      solde: ['', Validators.required],
      client: ['', Validators.required],
    });
  }
*/
 // DeleteClient(id:number){
   /* Swal.fire({
      title: "Good job!",
      text: "You clicked the button!",
      icon: "success"
    });*/
/*

  Swal.fire({
    title: "Êtes-vous sûr ?",
    text: "Une fois supprimé, vous ne pourrez plus le récupérer!",
    icon: "success"?
    buttons: true,
      dangerMode: true,
  });
      .then((willDelete) => {
          if (willDelete) {
              $.ajax({
                  url: "client/delete/" + id,
                  type: "GET",
                  success: function () {
                      $("#" + id).remove();
                      Swal("supprimé", {
                          icon: "success",
                      });
                  },
                  error: function () {
                      Swal("Poof! erreur serveur!", {
                          icon: "error",
                      });
                  }

              });
          } else {
              Swal("Pas grave!");
          }
      });
};*/
/*
  }
  
  ngOnInit() {



    const obs$ = ajax({
      url: 'https://httpbin.org/delay/2',
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'rxjs-custome-header': 'Angular Army'
      },
      body: {
        rxjs: 'Hello World!'
      }
    }).pipe(tap(userResponse => console.log('response is ', userResponse)));
    obs$.subscribe();

  


       this.httpClient.get('http://localhost:9999/clients/getClient').subscribe(
      (response: any) => {
        this.clients = response.data; // Extract the array from response.data
        console.log(this.clients);
      },
      (error) => {
        console.error('Error fetching clients:', error);
      }
    );
  }
  onSubmit() {
    // Handle form submission
    if (this.accountForm.valid) {
      const formData = this.accountForm.value;
      console.log('Form submitted with data:', formData);
      // Add logic to send data to your server or perform other actions
    }
  }


}*/


export class ListeuserComponent implements OnInit {

constructor(private userservice:UserService) { }

usersArray: any[] = [];

dtTrigger: Subject<any>= new Subject();


users!: any;
user : User=new User();
userlist:any;
isupdated = false;    
searchText!: string;
isHidden: boolean = true;
listClients:any
name:any

ngOnInit() {
  this.isupdated=false;
 this.getAllUser();
}


getClientbyName() {
  this.userservice.getUserbyName(this.name).subscribe(data => {
    this.isHidden = true;
    console.log(data)
    this.listClients = data
    
  },err=>{
    this.listClients = null;
  })
}



getAllUser(){
  this.userservice.getUserList().subscribe((response: any) =>{
    this.users =response.data;
    })
}


deleteUser(id :number) {
 

  
  Swal.fire({
    title: 'Êtes-vous sûr?',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Oui, supprimez-le!'
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire({
      title:'Supprimer Avec succés ',
      icon:'success',
      showConfirmButton: false,
      timer: 2000  
      })
      this.userservice.deleteUser(id)
      .subscribe(
        data => {
          console.log(data);
          
          this.getAllUser();
         
        },
        error => console.log(error));
    }
  })


}
updateUser(id: number){
  this.userservice.getUser(id)
    .subscribe(
      data => {
        this.userlist=data           
      },
      error => console.log(error));
}

userupdateform=new FormGroup({
  id:new FormControl(),
  nom:new FormControl(),
  prenom:new FormControl(),
  adresse:new FormControl()
});

updateStu(){
  this.user=new User(); 
 this.user.id=this.UserId!.value;
 this.user.nom=this.UserName!.value;
 this.user.prenom=this.UserPrenom!.value;
 this.user.adresse=this.UserAdresse!.value;
 

 this.userservice.updateUser(this.user.id,this.user).subscribe(
  data => {     
    this.isupdated=true;
    this.userservice.getUserList().subscribe(data =>{
      this.users =data
      })
  },
  error => console.log(error));
}

get UserName(){
  return this.userupdateform.get('nom');
}

get UserPrenom(){
  return this.userupdateform.get('prenom');
}

get UserAdresse(){
  return this.userupdateform.get('adresse');
}


get UserId(){
  return this.userupdateform.get('id');
}

changeisUpdate(){
  this.isupdated=false;
}
}

