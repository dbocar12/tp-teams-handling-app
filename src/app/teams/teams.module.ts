import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TeamListPageComponent} from './containers/team-list-page/team-list-page.component';
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {TeamDetailPageComponent} from './containers/team-detail-page/team-detail-page.component';
import {MatIconModule} from "@angular/material/icon";
import {FlexModule} from "@angular/flex-layout";
import {MatListModule} from "@angular/material/list";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {TeamAddPageComponent} from './containers/team-add-page/team-add-page.component';


@NgModule({
  declarations: [TeamListPageComponent, TeamDetailPageComponent, TeamAddPageComponent
  ],
  imports: [
    CommonModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    FlexModule,
    MatListModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule
  ]
})
export class TeamsModule {
}
