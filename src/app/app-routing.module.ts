import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TeamListPageComponent} from "./teams/containers/team-list-page/team-list-page.component";
import {TeamDetailPageComponent} from "@team-handling/teams/containers/team-detail-page/team-detail-page.component";
import {TeamAddPageComponent} from "@team-handling/teams/containers/team-add-page/team-add-page.component";


const routes: Routes = [
  {
    path: '',
    redirectTo: 'teams',
    pathMatch: 'full'
  },
  {
    path: 'teams',
    component: TeamListPageComponent
  },
  {
    path: 'team/:id',
    component: TeamDetailPageComponent
  },
  {
    path: 'teams/add',
    component: TeamAddPageComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
