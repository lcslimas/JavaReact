import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => {
    const imgStyle = {
        maxWidth: '150px',
        margin: '0 auto',
      };
    return(
        <header id="header bg-info">
            <div className="container">
                <div className="m-auto pt-2">
                    <Link to="/">
                        <figure className="logo d-flex m-0 justify-content-center">
                            <img style={imgStyle} src="https://image.flaticon.com/icons/png/512/2093/2093027.png" alt="BusterFlix" />
                        </figure>
                    </Link>
                </div>
            </div>
        </header>
    );
}

export default Header;