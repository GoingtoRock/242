//
//  GradientButton.h
//  Spend1
//
//  Created by Jaehwan Park on 2/28/15.
//  Copyright (c) 2015 Jaehwan Park. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <QuartzCore/QuartzCore.h>

@interface GradientButton : UIButton {
    CAGradientLayer *shineLayer;
    CALayer         *highlightLayer;
}
@end


