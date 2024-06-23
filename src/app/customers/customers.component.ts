import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CustomerService} from "../services/customer.service";
import {catchError, map, Observable, throwError} from "rxjs";
import {Customer} from "../model/customer.model";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit{
  custumers!:Observable<Array<Customer>>;
  errorMessage!:string;
  searchFormGroup! :FormGroup;
  constructor(private customerService:CustomerService , private  fb:FormBuilder, private router:Router) {}

  ngOnInit(): void {
    this.searchFormGroup=this.fb.group({
      keyword:this.fb.control("")
    });
    this.handleSearchCustumers();
  }

  handleSearchCustumers() {
 let kw= this.searchFormGroup?.value.keyword;
    this .custumers=this.customerService.searchCustomer(kw).pipe(
      catchError(err=>{
        this.errorMessage=err.message;
        return throwError(err);
      })
    );
  }

    handleDeleteCustumers(c: Customer) {
    let conf=confirm("ARE YOU SURE ?");
    if(!conf) return;
this.customerService.deleteCustomer(c.id).subscribe({
    next:(resp)=>{
this.custumers=this.custumers.pipe(
  map(data=>{
    let index=data.indexOf(c);
    return data.slice(index,1);
  })
);

 },
    error:err=>{
      console.log(err);
    }
})
    }

  handleCustomerAccounts(customer: Customer) {
    this.router.navigateByUrl("/customer-accounts/"+customer.id,{state :customer});
  }
}
