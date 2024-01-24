import { Component } from '@angular/core';

@Component({
  selector: 'app-listecompte',
  templateUrl: './listecompte.component.html',
  styleUrls: ['./listecompte.component.css']
})
export class ListecompteComponent {
  comptes: any[] = [
    { rib: '123', solde: 1000 },
    { rib: '456', solde: 2000 },
    { rib: '789', solde: 1500 },
    // Add more accounts as needed
  ];
  selectedClient: any;

  
  deleteCompte(rib: string) {
    // Add your delete logic here
  }
}
