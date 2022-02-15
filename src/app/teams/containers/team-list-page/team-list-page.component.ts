import {Component, OnInit} from '@angular/core';
import {Team} from "../../models/team";
import {TeamService} from "../../services/team.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-team-list-page',
  templateUrl: './team-list-page.component.html',
  styleUrls: ['./team-list-page.component.scss']
})
export class TeamListPageComponent implements OnInit {
  teams: Team[] | [];

  constructor(private teamService: TeamService, private router: Router) {
    this.teams = [];
  }

  ngOnInit() {
    this.teamService.getAllTeams().subscribe(data => {
      this.teams = data;
    });
  }

  onSelectTeam(team: Team): void {
    this.teamService.pushTeam(team);
    this.router.navigate([`team/${team.id}`]);
  }

  onAddTeam() {
    this.router.navigate([`teams/add`]);
  }

  deleteTeam(id: number | any): void {
    this.teamService.deletePost(id);
    this.router.navigate([`team/`]);


  }
}
