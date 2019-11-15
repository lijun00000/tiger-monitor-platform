import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HeaderComponent} from "./header/header.component";
import {PlatformManagementComponent} from "./platform-management/platform-management.component";
import {SystemManagementComponent} from "./system-management/system-management.component";
import {DataManagementComponent} from "./data-management/data-management.component";
import {LoginComponent} from "./login/login.component";


const routes: Routes = [
  {path: "header", component: HeaderComponent},
  {path: "platform-management", component: PlatformManagementComponent},
  {path: "system-management", component:SystemManagementComponent},
  {path: "data-management", component:DataManagementComponent},
  {path: "login", component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
