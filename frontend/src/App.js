import React from 'react';
import './App.scss';
import FoglalasRecordingForm from "./component/FoglalasRecordingForm";
import FoglalasList from "./component/FoglalasList";

function App() {
  return (
    <div className={["App","container"]}>
        <div className="header">
        <a href="#default" className="logo">Kemping</a>
        <div className="header-right">
            <a className="active" href="#home">Kezdőlap</a>
        </div>
    </div>
    <div id="content" className="round">
        <div id="firstdiv">
            <FoglalasRecordingForm/>
            <FoglalasList/>
        </div>
        <div id="firstdiv">
            <BillingRecordingForm/>
            <BillingList/>
        </div>
    </div>

    <footer className="round">
        <p>Group V</p>
    </footer>
    </div>
  );
}

export default App;
