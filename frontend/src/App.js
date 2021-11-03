import React from 'react';
import ReactDOM from 'react-dom';
import './styling/_app.scss';
import reportWebVitals from './reportWebVitals';

import Routes from "./Routes";
import { BrowserRouter as Router } from 'react-router-dom';

function App() {

  
    return (
      <div>
        <Router>
          <Routes/>
        </Router>
      </div>
    );
  

  
}

//ReactDOM.render(<Index />, document.getElementById("root"));

export default App;

/*import logo from './logos/logo_transparent.png';
import Index from './index.js'
import './App.css';
// Hello girl

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
      </header>
      <Index />
    </div>
  );
}

export default App;*/