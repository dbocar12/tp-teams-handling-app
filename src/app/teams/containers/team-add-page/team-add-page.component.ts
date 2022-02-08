import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TeamService} from "@team-handling/teams/services/team.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-team-add-page',
  templateUrl: './team-add-page.component.html',
  styleUrls: ['./team-add-page.component.scss']
})
export class TeamAddPageComponent implements OnInit {

  addTeamForm!: FormGroup;

  constructor(private fb: FormBuilder,
              private teamService: TeamService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.createForm();
  }

  createTeam() {
    if (this.addTeamForm.invalid) {  /****** on ne sauvegarde pas en base de donnée *****/
      return
    }

    const team = {
      name: this.addTeamForm.value.name,
      slogan: this.addTeamForm.value.slogan
    };
    this.teamService
      .addTeam(team)
      .subscribe(_ => this.router.navigate(['teams'])); /**** redirection vers la page teams ****/
  }

  private createForm(): void {
    this.addTeamForm = this.fb.group({
      name: ['', Validators.required],
      slogan: ['', Validators.required]
    })
  }

  cancel() {
    this.router.navigate(['teams'])
  }
}
