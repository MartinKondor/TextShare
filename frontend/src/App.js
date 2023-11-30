import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Navbar, NavbarBrand, Nav, NavItem, NavLink, Container, Row, Col } from 'reactstrap';
import './App.css';

import Home from './Dummy';

const defaultProfileImgUrl = 'favicon.ico';

const monthToName = monthNumber => [
    "January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"
][monthNumber - 1];

const timestampToDate = timestamp => {
    let date = new Date(timestamp * 1000);
    let hours = ("0" + date.getHours()).substring(1, 3);
    let minutes = ("0" + date.getMinutes()).substring(1, 3);
    let seconds = ("0" + date.getSeconds()).substring(1, 3);
    let year = date.getUTCFullYear();
    let month = ("0" + (date.getMonth() + 1)).substring(1, 3);
    let day = ("0" + date.getDate()).substring(1, 3);
    let monthName = monthToName(month).substring(0, 3).toLowerCase();
    return `${year} ${monthName}. ${day}. ${hours}:${minutes}:${seconds}`;
};

function App() {
    return (
        <div>
            <Navbar color="dark" dark expand="md" style={{ paddingLeft: '20px', paddingRight: '20px' }} className="justify-content-center">
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
            </Navbar>
            <Container className="mt-4">
                {Home.map(text => (
                    <div className="text-center text-body mb-4" key={text.id}>
                        <a href={'user/' + text.user.username}>
                            <img src={text.user.profileImgUrl || defaultProfileImgUrl} alt="Profile" className="mr-2" />
                            {text.user.username}
                        </a>
                        <Row className='mt-1'>
                            <Col>
                                <p className='mb-3 mt-3'>{text.content}</p>
                                <Row className='text-center'>
                                    <Col className='downvote fw-bold'>-{text.downvotes.length}</Col>
                                    <Col className='text-muted fw-bold'>{timestampToDate(text.timestamp)}</Col>
                                    <Col className='upvote fw-bold'>+{text.upvotes.length}</Col>
                                </Row>
                            </Col>
                        </Row>
                    </div>
                ))}
            </Container>
        </div>
    );
}

export default App;
