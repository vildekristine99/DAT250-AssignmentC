import React from 'react';
import ReactDOM from 'react-dom';
import './styling/index.scss';

import Routes from "./Routes";
import { BrowserRouter as Router } from 'react-router-dom';

class Index extends React.Component {

  render () {
    return (
    <div>
      <Router>

        <Routes/>
      </Router>
      
    </div>
    );
  };

  
}

ReactDOM.render(<Index />, document.getElementById("root"));