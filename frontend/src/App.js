import React from 'react';
import './styling/_app.scss';

import Routes from "./Routes";

class App extends React.Component {
	constructor(props) {
		super(props);
		this.logOut = this.logOut.bind(this);

		this.state = {
			currentUser: undefined,
		};
	}

	componentDidMount() {
		const user = AuthService.getCurrentUser();

		if (user) {
			this.setState({
				currentUser: user,
			});
		}
		//EventBus.on("logout", () => {
		//	this.logOut();
		//});
	}

	render() {
    return (
		  <Routes/>
	  );
  }

}

export default App;

