import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UserComponent } from './component/user/user.component';
import { EventListComponent } from './component/user/event-list/event-list.component';
import { EventCreateComponent } from './component/user/event-create/event-create.component';
import { SharedComponent } from './component/shared/shared.component';
import { HomeComponent } from './component/home/home.component';
import { EventComponent } from './component/event/event.component';
import { AuthComponent } from './component/auth/auth.component';
import { LoginComponent } from './component/auth/login/login.component';
import { SignupComponent } from './component/auth/signup/signup.component';
import { EventQuestionComponent } from './component/event/event-question/event-question.component';
import { EventPostQuestionComponent } from './component/event/event-post-question/event-post-question.component';
import { ToolbarComponent } from './component/shared/toolbar/toolbar.component';
import { SidenavListComponent } from './component/shared/sidenav-list/sidenav-list.component';
import { MaterialModule } from './material.module';
import { ReactiveFormsModule } from '@angular/forms';
import { AngularFireModule} from '@angular/fire/compat';


@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    EventListComponent,
    EventCreateComponent,
    SharedComponent,
    HomeComponent,
    EventComponent,
    AuthComponent,
    LoginComponent,
    SignupComponent,
    EventQuestionComponent,
    EventPostQuestionComponent,
    ToolbarComponent,
    SidenavListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    ReactiveFormsModule,


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
