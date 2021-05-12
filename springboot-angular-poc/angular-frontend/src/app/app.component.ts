import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from './login/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Angular Springboot CRUD Full Stack App';


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    public authenticationService: AuthenticationService) { }

  ngOnInit(): void {
  }

}
