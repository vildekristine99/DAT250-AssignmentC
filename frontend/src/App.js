import React from 'react';
import './styling/_app.scss';

import Routes from "./Routes";

class App extends React.Component {
	render() {
    return (
		  <Routes/>
	  );
  }
}
/*
class App extends React.Component {

  render() { 
		return (
			<div>
      <Route>
        <Routes/>
      </Route>
	  </div>
			/*<div>
      <Header />
	  <EnterPin />
	  </div>
		)
	}  
}

ReactDOM.render(
  <App />,
  document.getElementById('react')
);
*/
export default App;

