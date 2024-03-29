import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StoreModule } from '@ngrx/store';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { reducers } from './+store';
import { EffectsModule } from '@ngrx/effects';
import { GlobalEffects } from './+store/effects';
import { HttpClientModule } from '@angular/common/http'
import { UserModule } from './user/user.module';
import { metaReducers } from './+store/metaReducers';



@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    StoreModule.forRoot(reducers, { metaReducers }),
    UserModule,
    StoreDevtoolsModule.instrument({}),
    EffectsModule.forRoot([
      GlobalEffects
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
