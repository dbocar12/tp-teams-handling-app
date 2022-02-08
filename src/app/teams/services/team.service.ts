import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {Team} from "../models/team";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TeamService {
  private readonly teamsURL: string;
  private subject = new BehaviorSubject<Team>({id: 0, name: '', slogan: ''});


  constructor(private http: HttpClient) {
    this.teamsURL = 'http://localhost:8080/api/teams';
  }

  public getAllTeams(): Observable<Team[]> {
    return this.http.get<Team[]>(this.teamsURL);
  }

  public getTeamsById(id: number): Observable<Team> {
    return this.http.get<Team>(this.teamsURL + '?id=' + id);
  }

  public addTeam(team: Team): Observable<Team> {
    return this.http.post<Team>(this.teamsURL, team);
  }

  pushTeam(team: Team): void {
    this.subject.next(team);
  }

  pullTeam(): Observable<Team> {
    return this.subject.asObservable();
  }

}
