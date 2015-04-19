//
//  ViewController.h
//  Spend1
//
//  Created by Jaehwan Park on 2/19/15.
//  Copyright (c) 2015 Jaehwan Park. All rights reserved.
//

#import <UIKit/UIKit.h>



@interface ViewController : UIViewController {
    

    IBOutlet UIButton *spend;
    IBOutlet UIButton *sign_button;
    IBOutlet UIButton *login_button;


    NSTimer *moveObjectTimer;
    NSTimer *appearTimer;
    
}
@end

