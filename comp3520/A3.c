#define _CRT_SECURE_NO_WARNINGS
// Visual studio gives errors on scanf without this line above.
#include <SDL2/SDL.h>
#include <GL/glew.h>
#include <GL/GLU.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

// Julia Garant
// Winter 2021
// 104987469

int SCREEN_WIDTH = 600;
int SCREEN_HEIGHT = 600;
float x = 0, z = 0, angle = 0, xTable = 0, zTable = 0, angle_table = 0;;

// Drawing cubes
void drawCube(float r1, float g1, float b1, float r2, float g2, float b2){
    /* Front */
    glBegin(GL_POLYGON);
    glColor3f(r1, g1, b1);
    glVertex3f(0.5, -0.5, -0.5);
    glVertex3f(0.5, 0.5, -0.5);
    glVertex3f(-0.5, 0.5, -0.5);
    glVertex3f(-0.5, -0.5, -0.5);
    glEnd();

    /* Back */
    glBegin(GL_POLYGON);
    glVertex3f(0.5, -0.5, 0.5);
    glVertex3f(0.5, 0.5, 0.5);
    glVertex3f(-0.5, 0.5, 0.5);
    glVertex3f(-0.5, -0.5, 0.5);
    glEnd();

    /* Right */
    glBegin(GL_POLYGON);
    glColor3f(r2, g2, b2);
    glVertex3f(0.5, -0.5, -0.5);
    glVertex3f(0.5, 0.5, -0.5);
    glVertex3f(0.5, 0.5, 0.5);
    glVertex3f(0.5, -0.5, 0.5);
    glEnd();

    /* Left */
    glBegin(GL_POLYGON);
    glVertex3f(-0.5, -0.5, 0.5);
    glVertex3f(-0.5, 0.5, 0.5);
    glVertex3f(-0.5, 0.5, -0.5);
    glVertex3f(-0.5, -0.5, -0.5);
    glEnd();

    /* Top */
    glBegin(GL_POLYGON);
    glColor3f(r1 + 0.1, g1 + 0.1, b1 + 0.1);
    glVertex3f(0.5, 0.5, 0.5);
    glVertex3f(0.5, 0.5, -0.5);
    glVertex3f(-0.5, 0.5, -0.5);
    glVertex3f(-0.5, 0.5, 0.5);
    glEnd();

    /* Bottom */
    glBegin(GL_POLYGON);
    glColor3f(0.0, 0.0, 0.0);
    glVertex3f(0.5, -0.5, -0.5);
    glVertex3f(0.5, -0.5, 0.5);
    glVertex3f(-0.5, -0.5, 0.5);
    glVertex3f(-0.5, -0.5, -0.5);
    glEnd();

}

// Drawing the box
void drawOpenBox() {
    /* Front */
    glBegin(GL_POLYGON);
    glColor3f(1.0, 0.8, 0.0);
    glVertex3f(0.5, -0.5, -0.5);
    glVertex3f(0.5, 0.5, -0.5);
    glVertex3f(-0.5, 0.5, -0.5);
    glVertex3f(-0.5, -0.5, -0.5);
    glEnd();

    /* Back */
    glBegin(GL_POLYGON);
    glColor3f(1.0, 0.5, 0.0);
    glVertex3f(0.5, -0.5, 0.5);
    glVertex3f(0.5, 0.5, 0.5);
    glVertex3f(-0.5, 0.5, 0.5);
    glVertex3f(-0.5, -0.5, 0.5);
    glEnd();

    /* Right */
    glBegin(GL_POLYGON);
    glColor3f(1.0, 0.7, 0.0);
    glVertex3f(0.5, -0.5, -0.5);
    glVertex3f(0.5, 0.5, -0.5);
    glVertex3f(0.5, 0.5, 0.5);
    glVertex3f(0.5, -0.5, 0.5);
    glEnd();

    /* Left */
    glBegin(GL_POLYGON);
    glColor3f(1.0, 0.4, 0.0);
    glVertex3f(-0.5, -0.5, 0.5);
    glVertex3f(-0.5, 0.5, 0.5);
    glVertex3f(-0.5, 0.5, -0.5);
    glVertex3f(-0.5, -0.5, -0.5);
    glEnd();

    /* Bottom */
    glBegin(GL_POLYGON);
    glColor3f(1.0, 0.1, 0.0);
    glVertex3f(0.5, -0.5, -0.5);
    glVertex3f(0.5, -0.5, 0.5);
    glVertex3f(-0.5, -0.5, 0.5);
    glVertex3f(-0.5, -0.5, -0.5);
    glEnd();

}

// Drawing the box and it's objects
void drawBox(){
    // Where the key events take place

    x = fmax(x, -0.5);
    x = fmin(x, 0.5);

    z = fmax(z, -0.3);
    z = fmin(z, 0.3);

    glPushMatrix();
    // Rotate the box and all its objects together
    glTranslatef(x, 0, z);
    glRotatef(angle, 0, 1, 0);

    // Box
    glPushMatrix();
        glTranslatef(0, 0.078, 0);
        glScalef(0.3, 0.05, 0.3);
        drawOpenBox();
    glPopMatrix();

    // Obj 1
    glPushMatrix();
        glTranslatef(-0.08, 0.078, -0.08);
        glScalef(0.1, 0.04, 0.1);
        drawCube(0.0, 0.0, 1.0, 0.0, 0.5, 1.0);
    glPopMatrix();

    // Obj 2
    glPushMatrix();
        glTranslatef(0.08, 0.12, 0.08);
        glScalef(0.08, 0.1, 0.08);
        drawCube(1.0, 0.0, 1.0, 1.0, 0.5, 1.0);
    glPopMatrix();

    // Obj 3
    glPushMatrix();
        glTranslatef(-0.08, 0.15, 0.08);
        glScalef(0.06, 0.15, 0.06);
        drawCube(0.5, 0.0, 0.5, 0.5, 0.2, 0.5);
    glPopMatrix();

    glPopMatrix();
}

void drawFrame(){

    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    gluLookAt(0, 0, 0, 0.3, 0.8, -1, 0, 1, 0);              // Camera
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    glPushMatrix();

    // Move the table and everything on it
    glTranslatef(0 + xTable, 0, 0 + zTable); // TODO: Actually move it

    // Rotate the table and everything on it
    glRotatef(0 + angle_table, 0, 1, 0);

        // Box with open top
        drawBox();

        // Table top
        glPushMatrix();
            glTranslatef(0, 0, 0);
            glScalef(1.0, 0.1, 0.7);
            drawCube(0.0, 0.5, 0.0, 0.5, 0.5, 0.0);
        glPopMatrix();

        // Front left leg
        glPushMatrix();
            glTranslatef(-0.45, -0.3, -0.3);
            glScalef(0.05, 0.55, 0.05);
            drawCube(0.0, 0.5, 0.0, 0.5, 0.5, 0.0);
        glPopMatrix();

        // Back left leg
        glPushMatrix();
            glTranslatef(-0.45, -0.3, 0.3);
            glScalef(0.05, 0.55, 0.05);
            drawCube(0.0, 0.5, 0.0, 0.5, 0.5, 0.0);
        glPopMatrix();

        // Front right leg
        glPushMatrix();
            glTranslatef(0.45, -0.3, -0.3);
            glScalef(0.05, 0.55, 0.05);
            drawCube(0.0, 0.5, 0.0, 0.5, 0.5, 0.0);
        glPopMatrix();

        // Back right leg
        glPushMatrix();
            glTranslatef(0.45, -0.3, 0.3);
            glScalef(0.05, 0.55, 0.05);
            drawCube(0.0, 0.5, 0.0, 0.5, 0.5, 0.0);
        glPopMatrix();

    glPopMatrix();

    glFlush();
}


int main(int argc, char* argv[])
{
    // Initializing SDL
    SDL_Init(SDL_INIT_EVERYTHING);
    SDL_GL_SetAttribute(SDL_GL_CONTEXT_PROFILE_MASK, SDL_GL_CONTEXT_PROFILE_COMPATIBILITY);
    SDL_GL_SetAttribute(SDL_GL_CONTEXT_MAJOR_VERSION, 2);
    SDL_GL_SetAttribute(SDL_GL_CONTEXT_MINOR_VERSION, 1);

    // Creating SDL Window
    SDL_Window* window = SDL_CreateWindow("OpenGL", 100, 100, SCREEN_WIDTH, SCREEN_HEIGHT, SDL_WINDOW_OPENGL);
    if (!window)
    {
        printf("Cannot create the sdl window: %s", SDL_GetError());
        return -1;
    }
    // Creating GL context for the window, it is required for any gl functions to work
    SDL_GLContext context = SDL_GL_CreateContext(window);
    if (!context)
    {
        printf("Cannot create OpenGL context, probably the requested version of OpenGL is not supported on your machine.");
        printf("SDL ERROR: %s", SDL_GetError());
        return -1;
    }

    glViewport(0, 0, (GLsizei)SCREEN_WIDTH, (GLsizei)SCREEN_HEIGHT);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glMatrixMode(GL_MODELVIEW);     //between -1 and 1
    glLoadIdentity();

    glClearColor(1.0f, 1.0f, 1.0f, 0.0f); // Set clear color to white

    SDL_Event windowEvent;

    glEnable(GL_DEPTH_TEST);

    while (1)
    {
        if (SDL_PollEvent(&windowEvent))
        {
            if (windowEvent.type == SDL_QUIT) break;
            if (windowEvent.type == SDL_KEYUP &&
                windowEvent.key.keysym.sym == SDLK_ESCAPE)
            {
                break;
            }
            if (windowEvent.type == SDL_KEYDOWN)
            {      // Only move on key press
                switch (windowEvent.key.keysym.sym)
                {
                    // Moving box + objects
                case SDLK_a:
                    x -= 0.1;
                    break;

                case SDLK_d:
                    x += 0.1;
                    break;

                case SDLK_w:        
                    z += 0.1;
                    break;

                case SDLK_s:        
                    z -= 0.1;
                    break;

                    // Rotation of box + objects
                case SDLK_q:
                    angle += 5;
                    break;

                case SDLK_e:
                    angle -= 5;
                    break;

                    // Moving table + objects
                case SDLK_j:
                    xTable -= 0.1;
                    break;

                case SDLK_l:
                    xTable += 0.1;
                    break;

                case SDLK_i:
                    zTable += 0.1;
                    break;

                case SDLK_k:
                    zTable -= 0.1;
                    break;

                    // Rotation of table
                case SDLK_u:
                    angle_table += 5;
                    break;

                case SDLK_o:
                    angle_table -= 5;
                    break;

                
                default:
                    break;
                }
            }

        }

        glClear(GL_COLOR_BUFFER_BIT);

        drawFrame();

        SDL_GL_SwapWindow(window);
    }

    SDL_GL_DeleteContext(context);
    SDL_Quit();
    return 0;
}
