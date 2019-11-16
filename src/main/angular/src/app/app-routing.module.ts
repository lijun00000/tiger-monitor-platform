import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HeaderComponent} from "./header/header.component";
import {PlatformManagementComponent} from "./platform-management/platform-management.component";
import {SystemManagementComponent} from "./system-management/system-management.component";
import {DataManagementComponent} from "./data-management/data-management.component";
import {LoginComponent} from "./login/login.component";
import {LoginGuard} from "./guard/LoginGuard";


const routes: Routes = [
  {path: "", component: LoginComponent},
  {path: "header", component: HeaderComponent, canActivate: [LoginGuard]},
  {path: "platform-management", component: PlatformManagementComponent, canActivate: [LoginGuard]},
  {path: "system-management", component: SystemManagementComponent, canActivate: [LoginGuard]},
  {path: "data-management", component: DataManagementComponent, canActivate: [LoginGuard]},
  {path: "login", component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [LoginGuard]
})
export class AppRoutingModule {
}
