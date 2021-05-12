import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { AuthenticationService } from '../login/auth.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[];
  isLoggedIn = false;
  constructor(private employeeService: EmployeeService, private router: Router,
    private route: ActivatedRoute, private authenticationService: AuthenticationService) { }

  ngOnInit() {
    this.isLoggedIn = this.authenticationService.isUserLoggedIn();
    console.log('menu ->' + this.isLoggedIn);
    this.getEmployees();
  }

  handleLogout() {
    this.authenticationService.logout();

  }
  /*
  ngOnInit(): void {
    this.getEmployees();
  }*/
  private getEmployees() {
    this.employeeService.getEmployeesList().subscribe(data => {
      this.employees = data;
    });
  }
  employeeDetails(id: number) {
    this.router.navigate(['employee-details', id]);
  }
  updateEmployee(id: number) {
    this.router.navigate(['update-employee',id]);
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id).subscribe(data => {
      console.log(data);
      this.getEmployees();
    })
  }
}
