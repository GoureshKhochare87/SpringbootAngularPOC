import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  id: number;
  //employee: Employee;
  employee: Employee = new Employee();
  submitted = false;
  constructor(private employeeService: EmployeeService, private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    //this.employee = new Employee();
    this.id = this.route.snapshot.params['id'];

    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      console.log(data);
      this.employee = data;
    }, error => console.log(error));
  }
  newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
  }
  onSubmit() {
    this.employeeService.updateEmployee(this.id, this.employee).subscribe(data => {
      this.submitted = true;
      this.goToEmployeeList();
    }
      , error => console.log(error));
  }

  goToEmployeeList() {
    this.router.navigate(['/employees']);
  }
  private readonly emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
  private readonly mobileNoRegex = "^[a-zA-Z0-9]{10}";
  private readonly cityRegex = "^[a-zA-Z]*$";
  private readonly countryRegex = "^[a-zA-Z]*$";

  updateEmployee = new FormGroup({
    firstName: new FormControl('', [Validators.required, Validators.minLength(1), Validators.maxLength(30)]),
    lastName: new FormControl('', [Validators.required, Validators.minLength(1), Validators.maxLength(30)]),
    emailId: new FormControl('', [Validators.required, Validators.pattern(this.emailRegex)]),
    mobileNo: new FormControl('', [Validators.required, Validators.pattern(this.mobileNoRegex)]),
    city: new FormControl('', [Validators.required, Validators.pattern(this.cityRegex)]),
    country: new FormControl('', [Validators.required, Validators.pattern(this.countryRegex)])

  });

  isInvalidAndDirty(field: string): boolean {
    const ctrl = this.updateEmployee.get(field);
    return ctrl !== null && !ctrl.valid && ctrl.dirty;
  }

  hasError(field: string, error: string): boolean {
    const ctrl = this.updateEmployee.get(field);
    return ctrl !== null && ctrl.dirty && ctrl.hasError(error);
  }
}
