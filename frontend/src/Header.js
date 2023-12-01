import {Nav, Navbar, NavbarBrand, NavItem, NavLink} from "reactstrap";
import React from "react";

function Header() {
    return (<Navbar color="dark" dark expand="md" style={{ paddingLeft: '20px', paddingRight: '20px' }} className="justify-content-center">
        <NavbarBrand href="/">
            TextShare
        </NavbarBrand>
        <Nav className="ml-auto" navbar>
            <NavItem>
                <NavLink href="/">Home</NavLink>
            </NavItem>
            <NavItem>
                <NavLink href="/signup">Signup</NavLink>
            </NavItem>
            <NavItem>
                <NavLink href="/login">Login</NavLink>
            </NavItem>
        </Nav>
    </Navbar>);
}

export default Header;
