import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => {
    const imgStyle = {
        maxWidth: '120px',
      };
    return(
        <header id="header bg-info">
            <div className="container">
                <div className="m-auto pt-2 row">
                    <Link to="/movies">
                        <figure className="logo d-flex m-0 p-0 col-2">
                            <img style={imgStyle} src="https://image.flaticon.com/icons/png/512/2093/2093027.png" alt="BusterFlix" />
                        </figure>
                    </Link>
                    <h1 className="text-center justify-content-center d-flex my-auto ml-2">BusterFlix</h1>
                </div>
            </div>
        </header>
    );
}

export default Header;