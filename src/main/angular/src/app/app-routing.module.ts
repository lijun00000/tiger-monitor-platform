import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HeaderComponent} from "./header/header.component";
import {PlatformManagementComponent} from "./platform-management/platform-management.component";


const routes: Routes = [
  {path: "header", component:HeaderComponent},
  {path: "platform-management", component:PlatformManagementComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
