import React from "react";

const UserHome = () => {
    return (
    <div className="inputDiv">
        <button className="whiteButton">Create Polls</button>
        <button className="whiteButton">My Polls</button>
        <input className="pinInput" type="text" placeholder="Enter pin..."/>
    </div>
    );
}

export default UserHome;