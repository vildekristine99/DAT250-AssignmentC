import React from "react";
import { Route, Switch } from "react-router-dom";
import Header from "./Components/Header.jsx";
import Register from "./Components/Register.jsx";
import EnterPin from './Components/EnterPin.jsx';
import Login from './Components/Login.jsx';
import PublishPoll from "./Components/PublishPoll.jsx";
import UserHome from "./Components/UserHome.jsx";
import UserPolls from "./Components/UserPolls.jsx";
import AuthenticatedRoute from "./Components/Security/AuthenticatedRoute.jsx"
import LoginComponent from "./Components/Security/LoginComponent.jsx";
import ViewPoll from "./Components/ViewPoll.jsx";

export default function Routes(props) {

    return (
      <Switch>
        <Route exact path="/">
          <Header text="Log in" link="/#/login"/>
          <EnterPin />
        </Route>
        <Route path="/login">
          <Header text="Go back" link="/"/>
          <LoginComponent />
        </Route>
        <Route path="/register">
          <Header  text="Log in" link="/#/login"/> 
          <Register />
        </Route>
        <Route path="/publishPoll">
          <Header  text="Go back" link="/#/userHome"/>
          <PublishPoll />
        </Route>
        <Route path="/userHome">
          <Header  text="Log out" link="/"/>
          <UserHome />
        </Route>
        <Route path="/userPolls">
          <Header  text="Go back" link="/#/userHome"/>
          <UserPolls />
        </Route>{/*
        <Route path="/viewPoll">
          <Header text="Log out" link="/#/viewPoll"/>
          <ViewPoll />
        </Route>*/}
      </Switch>
    );
    
  }