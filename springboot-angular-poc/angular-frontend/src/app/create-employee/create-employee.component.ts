import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  employee: Employee = new Employee();
  submitted = false;
  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
  }
  saveEmployee() {
    this.employeeService.createEmployee(this.employee).subscribe(data => {
      console.log(data);
      this.goToEmployeeList();
    },
    error => console.log(error));
  }

  goToEmployeeList() {
    this.router.navigate(['/employees']);
  }

  onSubmit() {
    console.log(this.employee);
    this.submitted = true;
    this.saveEmployee();
  }
  //private readonly firstNameRegex = "^[a-zA-Z]*$";
  //private readonly lastNameRegex = "^[a-zA-Z]*$";
  private readonly emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
  private readonly mobileNoRegex = "^[a-zA-Z0-9]{10}";
  private readonly cityRegex = "^[a-zA-Z]*$";
  private readonly countryRegex = "^[a-zA-Z]*$";

  createEmployee = new FormGroup({
    firstName: new FormControl('', [Validators.required, Validators.minLength(1), Validators.maxLength(30)]),
    lastName: new FormControl('', [Validators.required, Validators.minLength(1), Validators.maxLength(30)]),
    emailId: new FormControl('', [Validators.required, Validators.pattern(this.emailRegex)]),
    mobileNo: new FormControl('', [Validators.required, Validators.pattern(this.mobileNoRegex)]),
    city: new FormControl('', [Validators.required, Validators.pattern(this.cityRegex)]),
    country: new FormControl('', [Validators.required, Validators.pattern(this.countryRegex)])

  });

  isInvalidAndDirty(field: string): boolean {
    const ctrl = this.createEmployee.get(field);
    return ctrl !== null && !ctrl.valid && ctrl.dirty;
  }

  hasError(field: string, error: string): boolean {
    const ctrl = this.createEmployee.get(field);
    return ctrl !== null && ctrl.dirty && ctrl.hasError(error);
  }
}
