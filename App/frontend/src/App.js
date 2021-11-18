import React from 'react';
import './styling/_app.scss';

import Routes from "./Routes";
import AuthService from "../src/Service/auth.service.js";

class App extends React.Component {


	render() {
    return (
		  <Routes/>
	  );
  }

}

export default App;

